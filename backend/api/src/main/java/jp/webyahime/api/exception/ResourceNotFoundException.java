package jp.webyahime.api.exception;

/**
 * リソースが存在しない場合にスローされる業務例外
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
