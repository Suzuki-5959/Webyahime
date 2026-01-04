package jp.webyahime.api.dto;

import java.time.LocalDateTime;

/**
 * 配信情報の詳細表示に使うためのDtoクラス
 * recordクラスにて実装
 */
public record StreamDetailDto(
        // 配信ID
        long streamId,

        // タイトル
        String title,

        // 概要
        String overview,

        // カテゴリID
        long categoryId,

        // カテゴリ名称
        String categoryName,

        // 登録日時
        LocalDateTime entryDatetime) {
}
