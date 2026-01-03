package jp.webyahime.api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

/**
 * 配信情報を新規登録するためのリクエスト情報DTOクラス
 */
@Getter
@AllArgsConstructor
public class StreamCreateRequest {

    // タイトル
    @NonNull
    @NotBlank
    @Size(max = 50)
    private final String title;

    // 概要
    @NonNull
    @Size(max = 5000)
    private final String overview;

    // ジャンルID
    @Min(1)
    private final long categoryId;

    // ユーザーID
    @NonNull
    @NotBlank
    private final String userId;

}
