package com.example.music_recommend_system.controller;

import com.example.music_recommend_system.common.request.FeedbackRequest;
import com.example.music_recommend_system.common.response.FeedbackResponse;
import com.example.music_recommend_system.common.response.RecommendResponse;
import com.example.music_recommend_system.entity.RecList;
import com.example.music_recommend_system.entity.Feedback;
import com.example.music_recommend_system.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recommend")
public class RecommendController {

    @Autowired
    private RecommendService recommendService;

    // 获取推荐的功能
    @GetMapping("/getrecommend")
    public RecommendResponse getRecommend(@RequestParam("user_id") Integer user_id) {
        RecommendResponse recommendResponse = new RecommendResponse();
        RecList recList;

        try {
            // 调用服务层查询推荐列表
            recList = recommendService.findByUserIdForRec(user_id);
        } catch (Exception e) {
            recommendResponse.setStatus("error");
            recommendResponse.setMessage("Failed to generate recommendations");
            recommendResponse.setUser_id(user_id);
            return recommendResponse;
        }

        if (recList.getRec_data().getArtists() == null || recList.getRec_data().getArtists().isEmpty()) {
            recommendResponse.setStatus("error");
            recommendResponse.setMessage("Query artists failed");
        } else if (recList.getRec_data().getTags() == null || recList.getRec_data().getTags().isEmpty()) {
            recommendResponse.setStatus("error");
            recommendResponse.setMessage("Query tags failed");
        } else {
            recommendResponse.setStatus("success");
            recommendResponse.setMessage("Recommendations generated successfully");
        }

        recommendResponse.setUser_id(user_id);
        recommendResponse.setRec_data(recList.getRec_data());
        return recommendResponse;
    }

    // 处理反馈的功能
    @PostMapping("/feedback")
    public FeedbackResponse handleFeedback(@RequestBody Feedback feedback) {
        FeedbackResponse feedbackResponse = new FeedbackResponse();
        boolean result;

        try {
            if (feedback.getFeedback_artist_id() != null) {
                result = recommendService.handleArtistFeedback(feedback);
            } else if (feedback.getFeedback_tag_id() != null) {
                result = recommendService.handleTagFeedback(feedback);
            } else {
                throw new IllegalArgumentException("Both artist_id and tag_id cannot be null.");
            }

            feedbackResponse.setStatus(result ? "success" : "error");
            feedbackResponse.setMessage(result ? "Feedback successfully" : "Feedback failed");

        } catch (Exception e) {
            feedbackResponse.setStatus("error");
            feedbackResponse.setMessage("An error occurred while submitting feedback: " + e.getMessage());
        }

        feedbackResponse.setUser_id(feedback.getUser_id());
        feedbackResponse.setFeedback_artist_id(feedback.getFeedback_artist_id());
        feedbackResponse.setLike_artist(feedback.getLike_artist());
        feedbackResponse.setDislike_artist(feedback.getDislike_artist());
        feedbackResponse.setFeedback_tag_id(feedback.getFeedback_tag_id());
        feedbackResponse.setLike_tag(feedback.getLike_tag());
        feedbackResponse.setDislike_tag(feedback.getDislike_tag());

        return feedbackResponse;
    }
}
