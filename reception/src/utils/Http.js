

import axios from 'axios';

const env = process.env.NODE_ENV;

axios.defaults.baseURL= (env ==='development')?'https://www.tjsanshao.top/':'https://www.tjsanshao.top/';


class Http {
    static get(url, params = {}, headers = {}){
        return new Promise((resolve, reject) => {
            axios.get(url, {
                params,
                headers
            }).then(res => {
                if (res.status === 200) {
                    resolve(res.data)
                } else {
                    reject(res.data)
                }
            }).catch(err => {
                reject(err);
            })
        })
    }

    static post(url, params = {}){
        return new Promise((resolve, reject) => {
            axios.post(url, params).then(res => {
                if (res.status === 200) {
                    resolve(res.data)
                } else {
                    reject(res.data)
                }
            }).catch(err => {
                reject(err)
            })
        })
    }
}

export default Http;