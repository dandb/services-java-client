package com.dandb.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccessToken {
	@SerializedName("access_token")
    @Expose public String access_token;
    public String expires_in;
    public String token_type;
    public String scope;
    public String refresh_token;
}
