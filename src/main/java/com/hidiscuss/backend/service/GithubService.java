package com.hidiscuss.backend.service;

import com.hidiscuss.backend.exception.GithubException;
import com.hidiscuss.backend.utils.GithubContext;
import org.kohsuke.github.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

@Service
public class GithubService {

    private GitHub getGitHub() {
        return GithubContext.getInstance();
    }

    public Collection<GHRepository> getRepositories() {
        try {
            return getGitHub().getUser("capstone-signal").getRepositories().values(); // TODO : get user from session
        } catch (IOException e) {
            throw new GithubException("Failed to get repositories", e);
        }
    }

    public Collection<GHCommit> getCommitsByRepoId(Long repoId) {
        try {
            return getGitHub().getRepositoryById(repoId).listCommits().toList();
        } catch (IOException e) {
            throw new GithubException("Failed to get commits", e);
        }
    }

    public Collection<GHPullRequest> getPullRequestsByRepoId(Long repoId) {
        try {
            return getGitHub().getRepositoryById(repoId).queryPullRequests().state(GHIssueState.ALL).list().toList();
        } catch (IOException e) {
            throw new GithubException("Failed to get pull requests", e);
        }
    }

    public GHPullRequest getPullRequestById(Long repoId, int pullRequestId) {
        try {
            return getGitHub().getRepositoryById(repoId).getPullRequest(pullRequestId);
        } catch (IOException e) {
            throw new GithubException("Failed to get pull request", e);
        }
    }

    public GHCommit getCommitById(Long repoId, String sha) {
        try {
            return getGitHub().getRepositoryById(repoId).getCommit(sha);
        } catch (IOException e) {
            throw new GithubException("Failed to get commit", e);
        }
    }

    public List<GHCommit.File> getFilesByCommit(GHCommit commit) {
        try {
            return commit.getFiles();
        } catch (IOException e) {
            throw new GithubException("Failed to get files", e);
        }
    }

    public List<GHPullRequestFileDetail> getFilesByPullRequest(GHPullRequest pr) {
        try {
            return pr.listFiles().toList();
        } catch (IOException e) {
            throw new GithubException("Failed to get files", e);
        }
    }
}
