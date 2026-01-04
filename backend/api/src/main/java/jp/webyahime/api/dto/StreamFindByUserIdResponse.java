package jp.webyahime.api.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ユーザーごとの配信一覧上で表示する配信情報を表すDTOクラス
 */
@Getter
@AllArgsConstructor
public class StreamFindByUserIdResponse {
    // 配信ID
    private final long streamId;

    // タイトル
    private final String title;

    // カテゴリ名称
    private final String categoryName;

    // 登録日時
    private final String entryDatetime;

    /**
     * 配信一覧上で表示する配信情報を返却するためのコンストラクタ、
     * 本コンストラクタではEntityより変換する際に必要となる項目のみを受け取る
     * 
     * 
     * @param streamId      配信ID
     * @param title         タイトル
     * @param entryDatetime 登録日時
     * 
     */
    public StreamFindByUserIdResponse(
            long streamId,
            String title,
            String categoryName,
            LocalDateTime entryDatetime) {
        this.streamId = streamId;
        this.title = title;
        this.categoryName = categoryName;
        this.entryDatetime = entryDatetime.toString();
    }
}
