export interface User {
    id?: number;
    email: string;
    password?: string;
    isAdmin: boolean;
    isLoggedIn: boolean;
    accessToken: string;
    refreshToken: string;
}
