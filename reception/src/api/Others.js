

import Http from "../utils/Http";


class Others {
    static async getAboutData(){
        const data = await Http.get('/public/other');
        return data ? data : null;
    }
}

export default Others;