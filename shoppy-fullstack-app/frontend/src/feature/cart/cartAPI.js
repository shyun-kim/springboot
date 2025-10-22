import React from 'react';
import { addCartItem, updateCartCount, 
         showCartItem, updateTotalPrice,
         updateCartItem, removeCartItem } from './cartSlice.js';
import { axiosData, axiosPost, axiosGet } from '../../utils/dataFetch.js';

export const removeCart = (cid) => async(dispatch) => {
    dispatch(removeCartItem({"cid": cid}));
    dispatch(updateTotalPrice());
    dispatch(updateCartCount()); 
}


export const showCart = () => async (dispatch) => {
    const jsonData = await axiosData("/data/products.json");
    dispatch(showCartItem({"items": jsonData}));
    dispatch(updateTotalPrice());
}

export const updateCart =  async(cid, type) => {
    String url = "/cart/updateQty";
    const data = {"cid": cid, "type": type};
    return 1;
//    dispatch(updateCartItem({"cid":cid, "type":type})); //수량변경
//    dispatch(updateTotalPrice());
//    dispatch(updateCartCount());
}

export const checkQty = async(pid, size) => {
    //쇼핑백 추가한 상품과 사이즈가 DB 테이블에 있는지 유무 확인
    const url = "/cart/checkQty";
    const data = {"pid": pid, "size":size};
    const checkRows = await axiosGet(url, data);
}

export const addCart = (pid, size) => async (dispatch) => {
    const checkResult = await checkQty(pid, size);
    if(!checkResult.checkQty) {
        const url = "/cart/add";
        const {userId} = JSON.parse(localStorage.getItem("loginInfo"));
        const item = {"pid":pid, "size":size, "qty":1, "id": userId};
        const rows = await axiosPost(url, item);
        alert("새로운 상품이 추가되었습니다.")
        dispatch(updateCartCount());
    } else {
        const rows = await updateCart(checkResult.cid, "+");
    }
    return 1;


//    dispatch(addCartItem({"cartItem":{"pid":pid, "size":size, "qty":1}}));
//    dispatch(updateCartCount());
}

