package com.syu.capsbe.domain.auth.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Schema(description = "로그인 응답 정보")
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class SignInResponseDto {

    @Schema(description = "액세스 토큰", example = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QHRlc3QuY29tIiwicm9sZXMiOlsiUk9MRV9VU0VSIl0sImlhdCI6MTcxMjIwOTc1MSwiZXhwIjoxNzE0ODAxNzUxfQ.RWRVAbvsM_Use6fwSGuMZ_FFa79xsGBrCwE-gYs3EGI")
    private final String accessToken;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    @Schema(description = "토큰 유효기간", example = "2024-04-19T14:32:37")
    private final Date expiresAt;

    public static SignInResponseDto of(String accessToken, Date expiresAt) {
        return new SignInResponseDto(accessToken, expiresAt);
    }
}
