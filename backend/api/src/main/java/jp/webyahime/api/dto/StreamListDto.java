package jp.webyahime.api.dto;

import java.time.LocalDateTime;

/**
 * 配信情報の一覧表示に使うためのDtoクラス
 * recordクラスにて実装
 */
public record StreamListDto(
        // 配信ID
        Long streamId,

        // タイトル
        String title,

        // カテゴリ名称
        String categoryName,

        // 登録日時
        LocalDateTime entryDatetime) {
}
