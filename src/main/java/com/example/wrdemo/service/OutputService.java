package com.example.wrdemo.service;

import java.sql.Timestamp;

public interface OutputService {
    void SaveOutput(int userId, String output, Timestamp time);
}
