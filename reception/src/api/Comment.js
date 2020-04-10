

import Http from "../utils/Http";


class Comment {
    static async getCommentList(currentPage=1,pageSize=10){
        const data = await Http.get('/public/comment/list',{
            currentPage,
            pageSize
        });
        return data ? data : null;
    }

    static async publishComment(content,nickName){
        const result = await Http.post('/api/comment/publishMsg',{
            content,nickName
        });
        if(result.statusCode === 200){
            return result.message;
        }
        return false;
    }
}

export default Comment;