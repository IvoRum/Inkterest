package com.ink.bo;

import java.sql.Date;

public record UserBO(String username, String firstName, String surName, String lastName, Date dateOfBirth) {
}
