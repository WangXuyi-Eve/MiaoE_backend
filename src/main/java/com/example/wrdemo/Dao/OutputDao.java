package com.example.wrdemo.Dao;

import java.sql.Timestamp;

public interface OutputDao {
    void SaveOutput(int userId, String output, Timestamp time);
}
