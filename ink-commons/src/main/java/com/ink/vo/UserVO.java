package com.ink.vo;

import com.ink.Status;

import java.sql.Date;

public record UserVO(String username, String password, String firstName, String surName, String lastName, Status status, Date dateOfBirth) {
}
