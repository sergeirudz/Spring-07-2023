import { defineStore } from "pinia";
import { User } from "types/models/User";

const initialState: User = {
    email: "",
    isAdmin: false,
    isLoggedIn: false,
    accessToken: "",
    refreshToken: "",
};

export const useUserStore = defineStore("userStore", {
    state: (): User => {
        return initialState;
    },
    actions: {
        updateLoginState(this: User, payload: boolean) {
            this.isLoggedIn = payload;
        },
        updateAccessToken(this: User, payload: string) {
            this.accessToken = payload;
        },
        updateRefreshToken(this: User, payload: string) {
            this.refreshToken = payload;
        },
        logout(this: User) {
            this.email = "";
            this.isAdmin = false;
            this.isLoggedIn = false;
            this.accessToken = "";
            this.refreshToken = "";
        },
        async registerUser(this: User, payload: Pick<User, "email" | "password">) {
            const response = await fetch("/api/auth/register", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(payload),
            });
            const data = await response.json();
            return data;
        },

        async loginUser(this: User, payload: Pick<User, "email" | "password">) {
            const response = await fetch("/api/auth/login", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(payload),
            });
            const data = await response.json();
            return data;
        },
    },
});
