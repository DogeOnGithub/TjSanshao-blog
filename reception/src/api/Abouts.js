

import Http from "../utils/Http";


class Abouts {
    static async getAboutData(){
        const data = await Http.get('/public/about');
        return data ? data : null;
    }
}

export default Abouts;