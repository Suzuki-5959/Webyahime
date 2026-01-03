package jp.webyahime.api.entity;

import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 配信情報テーブルを表すEntityクラス
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class StreamEntity {

    // 配信ID
    private long streamId;

    // タイトル
    private String title;

    // 概要
    private String overview;

    // カテゴリID
    private long categoryId;

    // ユーザーID
    private String userId;

    // 登録日時
    private LocalDateTime entryDatetime;

    // 更新日時
    private LocalDateTime updateDatetime;

    // 削除フラグ
    private boolean delFlg;

    /**
     * 配信情報を新規登録するためのコンストラクタ、
     * 本コンストラクタでは登録時に必須となる項目のみを受け取り、
     * 定義しない情報についてはDBで定義されたdefault値を利用する、
     * 
     * @param title      タイトル(必須)
     * @param overview   概要(必須)
     * @param categoryId カテゴリID(必須)
     * @param userId     ユーザーID(必須)
     */
    public StreamEntity(String title,
            String overview,
            long categoryId,
            String userId) {
        this.title = title;
        this.overview = overview;
        this.categoryId = categoryId;
        this.userId = userId;
    }
}
