package com.replit.demo.controller;

import com.replit.demo.service.GithubService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/github")
public class GithubController {

  @Autowired
  private GithubService githubService;

  @GetMapping("/getLatestCommitMessage")
  public String fetchLatestCommitMessage() {
    return githubService.fetchLatestCommitMessage();
  }
}