package com.ink.bo;

import java.util.List;

public record StudioBO(String name, List<UserBO> staff, UserBO owner, List<UserBO> admin, LocationBO location) {
}
