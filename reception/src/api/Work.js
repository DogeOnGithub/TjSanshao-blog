

import Http from "../utils/Http";


class Work {
    static async getWorkData(){
        const data = await Http.get('/public/works');
        return data ? data : null;
    }
}

export default Work;