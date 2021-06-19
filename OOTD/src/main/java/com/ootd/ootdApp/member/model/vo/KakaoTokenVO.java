package com.ootd.ootdApp.member.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KakaoTokenVO {
	
	private String access_token;
    private String token_type;
    private String refresh_token;
    private String expires_in;
    private String refresh_token_expires_in;
}
