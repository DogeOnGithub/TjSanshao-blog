

import Http from "../utils/Http";


class Homes {
    static async getHomeData(){
        const data = await Http.get('/public/home');
        return data ? data : null;
    }
}

export default Homes;