package com.replit.demo.service;

import java.io.IOException;

import org.kohsuke.github.GHBranch;
import org.kohsuke.github.GHCommit;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import org.springframework.stereotype.Service;

@Service
public class GithubService {

  public String fetchLatestCommitMessage() {
    // Replace YOUR_ACCESS_TOKEN with your actual access token
    String message;
    try {
      GitHub github = new GitHubBuilder().withOAuthToken(System.getenv("oauth_token")).build();
      GHRepository repo = github.getRepository("jhyhit/Replit-Demo");
      GHBranch branch = repo.getBranch("main");
      GHCommit commit = repo.getCommit(branch.getSHA1());
      message = commit.getCommitShortInfo().getMessage();
    } catch (IOException e) {
      e.printStackTrace();
      return "";
    }
    return message;
  }
}
