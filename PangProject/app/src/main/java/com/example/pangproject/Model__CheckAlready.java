package com.example.pangproject;

import retrofit2.Call;

// 보내는 값
class CallApi {
        public static String requestId = "sss";
        public static String requestPassward = "1111";

       /* public void CallApi(String responceId) {
            this.requestId = responceId;
        }*/

        public String getRequestId() {
            return requestId;
        }

        public void setRequestId(String i) {
            this.requestId = requestId;
        }

        public String getRequestPassward() {
            return requestPassward;
        }

        public void setRequestPassward() {
            this.requestPassward = requestPassward;
        }

        public String toString() {
            return "RepoCheckAlready{" +
                    "id: <"+ requestId + ">," +
                    "\n passward: <" + requestPassward + ">" +
                    '}';
        }

        public boolean isRight() {

            return false;
        }

    public Call<Model__CheckAlready> postOverlapCheck(Model__CheckAlready modelCheckAlready) {
        return null;
    }
}


// 받는 값
public class Model__CheckAlready {
    static int responseId= 200;
    static String responsePassward;

    public Model__CheckAlready(int responceId) {
        this.responseId = responceId;
    }

    public int getRequestId() {
        return responseId;
    }

    public void setRequestId(int i) {
        this.responseId = responseId;
    }

    public String getRequestPassward() {
        return responsePassward;
    }

    public void setRequestPassward() {
        this.responsePassward = responsePassward;
    }

    public boolean isRight() {

        return false;

    }

    public Call postOverlapCheck(Model__CheckAlready modelCheckAlready) {

        return null;
    }
}