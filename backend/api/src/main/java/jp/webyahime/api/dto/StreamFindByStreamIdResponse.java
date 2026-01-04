package jp.webyahime.api.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 配信IDごとの配信情報を表すDTOクラス
 */
@Getter
@AllArgsConstructor
public class StreamFindByStreamIdResponse {
    // 配信ID
    private final long streamId;

    // タイトル
    private final String title;

    // 概要
    private final String overview;

    // カテゴリID
    long categoryId;

    // カテゴリ名称
    String categoryName;

    // 登録日時
    private final String entryDatetime;

    /**
     * 配信IDごとの配信情報を返却するためのコンストラクタ、
     * 本コンストラクタではEntityより変換する際に必要となる項目のみを受け取る
     * 
     * @param streamId      配信ID
     * @param title         タイトル
     * @param entryDatetime 登録日時
     */
    public StreamFindByStreamIdResponse(
            long streamId,
            String title,
            String overview,
            long categoryId,
            String categoryName,
            LocalDateTime entryDatetime) {
        this.streamId = streamId;
        this.title = title;
        this.overview = overview;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.entryDatetime = entryDatetime.toString();
    }
}
