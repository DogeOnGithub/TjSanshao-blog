

import Http from "../utils/Http";


class Blogs {
    static async getBlogData(){
        const data = await Http.get('/public/blog');
        return data ? data : null;
    }
}

export default Blogs;