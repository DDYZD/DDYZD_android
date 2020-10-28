package com.example.pangproject;

import retrofit2.Call;

// 보내는 값
class CallApi {
        static String responsetId="sss";
        static String respnsePassward="1111";

        public void CallApi(String responceId) {
            this.responsetId = responceId;
        }

        public String getRequestId() {
            return responsetId;
        }

        public void setRequestId(String i) {
            this.responsetId = responsetId;
        }

        public String getRequestPassward() {
            return respnsePassward;
        }

        public void setRequestPassward() {
            this.respnsePassward = respnsePassward;
        }

        public String toString() {
            return "RepoCheckAlready{" +
                    "id: <"+ responsetId + ">," +
                    "\n passward: <" + respnsePassward + ">" +
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
    static int requestId;
    static String requestPassward;

    public Model__CheckAlready(int responceId) {
        this.requestId = responceId;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int i) {
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
                "id: <" + requestId + ">," +
                "\n passward: <" + requestPassward + ">" +
                '}';
    }

    public boolean isRight() {

        return false;

    }
}