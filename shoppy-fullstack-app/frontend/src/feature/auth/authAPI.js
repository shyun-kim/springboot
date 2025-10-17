import { login, logout } from "./authSlice.js";
import { validateFormCheck, validateSignupFormCheck } from "../../utils/validate.js";
import { axiosPost } from "../../utils/dataFetch.js";


/**
  Duplicate check
*/
export const getIdCheck = (id) => async(dispatch) => {
    const data = { "id": id }; //JSON 타입으로 보내기 위해서 {} 안에 적음
    const url = "http://localhost:8080/member/idcheck";
    const result = await axiosPost(url, data);
    return result;
}


/**
  Sign up
*/
export const getSignup = (formData, param) => async(dispatch) => {
    let result = null;
    if(validateSignupFormCheck(param)) {
        const url = "http://localhost:8080/member/signup";
        const result = await axiosPost(url, formData);
    }
    return result;
}

/**
 Login
*/
export const getLogin = (formData, param) => async(dispatch) => {
    if(validateFormCheck(param)) {
        /**
            SpringBoot - @RestController, @PostMapping("/member/login") -(formData가 JSON 파일로 생성됨)
            axios api
        */
        const url = "http://localhost:8080/member/login";
        const result = await axiosPost(url, formData);
        if(result) {
            dispatch(login({"userId" : formData.id}));
            return true;
        }
    }
    return false;
}

export const getLogout = () => async(dispatch) => {
    dispatch(logout());
    return true;
}