package jp.webyahime.api.entity;

import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * カテゴリ情報マスタを表すEntityクラス
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CategoryEntity {
    // カテゴリID
    private long categoryId;

    // カテゴリ名称
    private String categoryName;

    // 登録日時
    private LocalDateTime entryDatetime;

    // 更新日時
    private LocalDateTime updateDatetime;

    // 削除フラグ
    private boolean delFlg;

}
