

import React,{memo} from 'react';

import PropTypes from 'prop-types';

import './msg-card.scss';

import moment from 'moment';


const MsgCard = (props) =>{
        const {content,createAt,nickName} = props;
        const dateFormat = (date) => moment(date).format('YYYY-MM-DD HH:mm:ss');
        return (
            <div className={'msg-card'}>
                <div className={'msg-card-content'}>{content}</div>
                <div className={'msg-card-item'}>
                    <p className={'msg-card-nickName'}>Publish from {nickName}</p>
                    <p className={'msg-card-time'}>Publish At {dateFormat(createAt)}</p>
                </div>
            </div>
        );
};

MsgCard.propTypes = {
    content:PropTypes.string.isRequired,
    createAt:PropTypes.string.isRequired,
    nickName:PropTypes.string
};

MsgCard.defaultProps = {
    nickName:'匿名用户'
};


export default memo(MsgCard);