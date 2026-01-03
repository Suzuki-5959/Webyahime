package jp.webyahime.api.dto;

/**
 * エラーレスポンスDTO
 * 簡単にイミュータブルなクラスを記述できる「recordクラス」で作成してみる
 */
public record ErrorResponse(
        String code,
        String message) {
}