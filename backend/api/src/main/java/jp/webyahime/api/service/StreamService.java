package jp.webyahime.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jp.webyahime.api.dto.StreamCreateRequest;
import jp.webyahime.api.dto.StreamFindByStreamIdResponse;
import jp.webyahime.api.dto.StreamFindByUserIdResponse;
import jp.webyahime.api.entity.StreamEntity;
import jp.webyahime.api.exception.ResourceNotFoundException;
import jp.webyahime.api.mapper.StreamMapper;
import lombok.RequiredArgsConstructor;

/**
 * 配信情報の業務ロジックを管理するサービスクラス
 */
@Service
@RequiredArgsConstructor
public class StreamService {
    private final StreamMapper streamMapper;

    /**
     * 配信情報の新規登録メソッド
     * 
     * @param streamCreateRequest 必須のリクエスト情報(タイトル、概要、カテゴリID、ユーザーID)
     * @return 登録された配信情報のID
     */
    public long create(StreamCreateRequest streamCreateRequest) {
        // reqestDto->Entityへの変換
        StreamEntity streamEntity = new StreamEntity(streamCreateRequest.getTitle(),
                streamCreateRequest.getOverview(), streamCreateRequest.getCategoryId(),
                streamCreateRequest.getUserId());
        return streamMapper.create(streamEntity);
    };

    /**
     * 指定したユーザーの配信情報一覧を取得するメソッド
     * Mapperから受け取った配信情報エンティティのリストをレスポンス用のリストへ変換してContllolerへ返却
     * 
     * @param userId 配信情報の取得対象となるユーザーID
     * @return 指定されたユーザーの配信情報(配信ID、タイトル、登録日時)のリスト
     */
    public List<StreamFindByUserIdResponse> findByUserId(String userId) {
        List<StreamFindByUserIdResponse> responseList = new ArrayList<>();
        for (StreamEntity streamEntity : streamMapper.findByUserId(userId)) {
            responseList.add(new StreamFindByUserIdResponse(
                    streamEntity.getStreamId(),
                    streamEntity.getTitle(),
                    streamEntity.getEntryDatetime()));
        }
        return responseList;
    }

    /**
     * 指定したIDの配信情報を取得するメソッド
     * Mapperから受け取った配信情報エンティティのリストをレスポンス用のリストへ変換してContllolerへ返却
     * 
     * @param streamId 取得対象となる配信情報のID
     * @return 指定されたIDの配信情報(配信ID、タイトル、概要、登録日時)一件
     */
    public StreamFindByStreamIdResponse findByStreamId(String streamId) {
        StreamEntity entity = streamMapper.findByStreamId(Long.parseLong(streamId));
        StreamFindByStreamIdResponse response = new StreamFindByStreamIdResponse(
                entity.getStreamId(),
                entity.getTitle(),
                entity.getOverview(),
                entity.getEntryDatetime());
        return response;
    }

    /**
     * 指定したIDの配信情報を取得するメソッド
     * Mapperクラスからの更新件数によってエラーハンドリングを行う
     * 
     * @param streamId 削除対象となる配信情報のID
     */
    public void delete(String streamId) {
        long updated = streamMapper.delete(Long.parseLong(streamId));
        if (updated == 0) {
            throw new ResourceNotFoundException("not found or already deleted");
        }
    }
}
