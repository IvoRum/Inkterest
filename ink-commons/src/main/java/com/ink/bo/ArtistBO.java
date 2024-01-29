package com.ink.bo;

import java.util.List;

public record ArtistBO(UserBO userData, List<PostBO> poset) {
}
