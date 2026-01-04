package jp.webyahime.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jp.webyahime.api.dto.StreamCreateRequest;
import jp.webyahime.api.dto.StreamDetailDto;
import jp.webyahime.api.dto.StreamFindByStreamIdResponse;
import jp.webyahime.api.dto.StreamFindByUserIdResponse;
import jp.webyahime.api.dto.StreamListDto;
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
     * Mapperから受け取った配信情報のリストをレスポンス用のリストへ変換してContllolerへ返却
     * 
     * @param userId 配信情報の取得対象となるユーザーID
     * @return 指定されたユーザーの配信情報(配信ID、タイトル、カテゴリ名称、登録日時)のリスト
     */
    public List<StreamFindByUserIdResponse> findByUserId(String userId) {
        List<StreamFindByUserIdResponse> responseList = new ArrayList<>();
        for (StreamListDto streamListDto : streamMapper.findByUserId(userId)) {
            responseList.add(new StreamFindByUserIdResponse(
                    streamListDto.streamId(),
                    streamListDto.title(),
                    streamListDto.categoryName(),
                    streamListDto.entryDatetime()));
        }
        return responseList;
    }

    /**
     * 指定したIDの配信情報を取得するメソッド
     * Mapperから受け取った配信情報エンティティのリストをレスポンス用のリストへ変換してContllolerへ返却
     * 
     * @param streamId 取得対象となる配信情報のID
     * @return 指定されたIDの配信情報(配信ID、タイトル、概要、カテゴリID、カテゴリ名称、登録日時)一件
     */
    public StreamFindByStreamIdResponse findByStreamId(String streamId) {
        StreamDetailDto detailDto = streamMapper.findByStreamId(Long.parseLong(streamId));
        StreamFindByStreamIdResponse response = new StreamFindByStreamIdResponse(
                detailDto.streamId(),
                detailDto.title(),
                detailDto.overview(),
                detailDto.categoryId(),
                detailDto.categoryName(),
                detailDto.entryDatetime());
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
