package com.swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D4_6109_추억의2048게임_시뮬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; ++t) {
            String[] NS = br.readLine().split(" ");
            int N = Integer.parseInt(NS[0]);
            String dir = NS[1];

            int[][] map = new int[N][N];
            for (int i = 0; i < N; ++i) {
                String[] s = br.readLine().split(" ");
                for (int j = 0; j < N; ++j) {
                    map[i][j] = Integer.parseInt(s[j]);
                }
            }

            switch (dir) {
                case "up":
                    for (int i = 0; i < N; ++i) {
                        for (int j = N - 1; j > 0; --j) {
                            if (map[j][i] == 0) {
                                for (int k = j; k < N - 1; ++k) {
                                    map[k][i] = map[k + 1][i];
                                    map[k + 1][i] = 0;
                                }
                            }
                        }
                    }

                    for (int i = 0; i < N; ++i) {
                        for (int j = 0; j < N - 1; ++j) {
                            if (map[j][i] == map[j + 1][i]) {
                                map[j][i] = map[j][i] * 2;
                                map[j + 1][i] = 0;
                                ++j;
                            }
                        }
                    }

                    for (int i = 0; i < N; ++i) {
                        for (int j = 0; j < N - 1; ++j) {
                            if (map[j][i] == 0) {
                                for (int k = j; k < N - 1; ++k) {
                                    map[k][i] = map[k + 1][i];
                                    map[k + 1][i] = 0;
                                }
                            }
                        }
                    }
                    break;
                case "down":
                    for (int i = 0; i < N; ++i) {
                        for (int j = 0; j < N - 1; ++j) {
                            if (map[j][i] == 0) {
                                for (int k = j; k > 0; --k) {
                                    map[k][i] = map[k - 1][i];
                                    map[k - 1][i] = 0;
                                }
                            }
                        }
                    }

                    for (int i = 0; i < N; ++i) {
                        for (int j = N - 1; j > 0; --j) {
                            if (map[j][i] == map[j - 1][i]) {
                                map[j][i] = map[j][i] * 2;
                                map[j - 1][i] = 0;
                                --j;
                            }
                        }
                    }

                    for (int i = 0; i < N; ++i) {
                        for (int j = N - 1; j > 0; --j) {
                            if (map[j][i] == 0) {
                                for (int k = j; k > 0; --k) {
                                    map[k][i] = map[k - 1][i];
                                    map[k - 1][i] = 0;
                                }
                            }
                        }
                    }
                    break;
                case "right":
                    for (int i = 0; i < N; ++i) {
                        for (int j = 0; j <  N - 1; ++j) {
                            if (map[i][j] == 0) {
                                for (int k = j; k > 0; --k) {
                                    map[i][k] = map[i][k - 1];
                                    map[i][k - 1] = 0;
                                }
                            }
                        }
                    }

                    for (int i = 0; i < N; ++i) {
                        for (int j = N - 1; j > 0; --j) {
                            if (map[i][j] == map[i][j - 1]) {
                                map[i][j] = map[i][j] * 2;
                                map[i][j - 1] = 0;
                                --j;
                            }
                        }
                    }

                    for (int i = 0; i < N; ++i) {
                        for (int j = N - 1; j > 0; --j) {
                            if (map[i][j] == 0) {
                                for (int k = j; k > 0; --k) {
                                    map[i][k] = map[i][k - 1];
                                    map[i][k - 1] = 0;
                                }
                            }
                        }
                    }
                    break;
                case "left":
                    for (int i = 0; i < N; ++i) {
                        for (int j = N - 1; j > 0; --j) {
                            if (map[i][j] == 0) {
                                for (int k = j; k < N - 1; ++k) {
                                    map[i][k] = map[i][k + 1];
                                    map[i][k + 1] = 0;
                                }
                            }
                        }
                    }

                    for (int i = 0; i < N; ++i) {
                        for (int j = 0; j < N - 1; ++j) {
                            if (map[i][j] == map[i][j + 1]) {
                                map[i][j] = map[i][j] * 2;
                                map[i][j + 1] = 0;
                                ++j;
                            }
                        }
                    }

                    for (int i = 0; i < N; ++i) {
                        for (int j = 0; j < N - 1; ++j) {
                            if (map[i][j] == 0) {
                                for (int k = j; k < N - 1; ++k) {
                                    map[i][k] = map[i][k + 1];
                                    map[i][k + 1] = 0;
                                }
                            }
                        }
                    }
                    break;
            }

            System.out.println("#" + t);
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }

        }
    }
}
