

import Http from "../utils/Http";


class Comment {
    static async getCommentList(current = 1,pageSize = 10){
        const data = await Http.get('/public/comment/list',{
            current,
            pageSize
        });
        return data ? data : null;
    }

    static async publishComment(content,nickName){
        const result = await Http.post('/public/comment/publish',{
            content,nickName
        });
        return result;
    }
}

export default Comment;