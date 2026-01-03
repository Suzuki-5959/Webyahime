package jp.webyahime.api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import jp.webyahime.api.dto.StreamCreateRequest;
import jp.webyahime.api.dto.StreamFindByStreamIdResponse;
import jp.webyahime.api.dto.StreamFindByUserIdResponse;
import jp.webyahime.api.service.StreamService;
import lombok.RequiredArgsConstructor;

/**
 * 配信情報を管理するControllerクラス
 */
@RestController
@RequestMapping("/streams")
@RequiredArgsConstructor
public class StreamController {
    private final StreamService streamService;

    /**
     * 配信情報の新規登録メソッド
     * 
     * @param streamCreateRequest 登録される配信情報(タイトル、概要、カテゴリID、ユーザーID)
     */
    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody StreamCreateRequest streamCreateRequest) {
        long id = streamService.create(streamCreateRequest);
        URI location = URI.create("/streams/" + id);
        return ResponseEntity.created(location).build();
    };

    /**
     * 指定したユーザーの配信情報一覧を取得するメソッド
     * 
     * @param userId 配信情報の取得対象となるユーザーID
     * @return 指定されたユーザーの配信情報(配信ID、タイトル、登録日時)のリスト
     */
    @GetMapping
    public List<StreamFindByUserIdResponse> findByUserId(@RequestParam String userId) {
        return streamService.findByUserId(userId);
    }

    /**
     * 指定したIDの配信情報一覧を取得するメソッド
     * 
     * @param streamId 配信情報の取得対象となる配信ID
     * @return 指定されたIDの概要
     */
    @GetMapping("/{streamId}")
    public StreamFindByStreamIdResponse findByStreamId(@PathVariable String streamId) {
        return streamService.findByStreamId(streamId);
    }

    /**
     * 指定したIDの配信情報を論理削除するメソッド
     * 
     * @param streamId 配信情報の取得対象となる配信ID
     */
    @DeleteMapping("/{streamId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String streamId) {
        streamService.delete(streamId);
    }
}
