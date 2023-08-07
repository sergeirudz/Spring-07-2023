export interface User {
  id: number;
  email: string;
  isAdmin: boolean;
  isLoggedIn: boolean;
  accessToken: string;
  refreshToken: string;
}
