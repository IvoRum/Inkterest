package com.ink.vo;

import com.ink.bo.UserBO;

import java.util.List;

public record StudioVO(String name, List<UserVO> staff, UserBO owner, List<UserVO> admin, LocationVO location) {
}
