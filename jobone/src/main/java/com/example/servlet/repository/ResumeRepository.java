package com.example.servlet.repository;

import com.example.servlet.entity.JobMessage;
import com.example.servlet.entity.Resume;
import com.example.servlet.entity.ResumeEntity;

import java.util.List;

public interface ResumeRepository {

  public int save(Resume resume);
    public List<Resume> findAllby(Resume resume );
}
