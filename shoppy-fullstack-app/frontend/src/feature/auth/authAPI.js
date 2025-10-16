import { login, logout } from "./authSlice.js";
import { validateFormCheck } from "../../utils/validate.js"
import { axiosPost } from "../../utils/dataFetch.js"

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