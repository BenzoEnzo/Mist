export interface ReadMessageRequest {
    id: string;
}

export interface ReadMessageResponse {
    content: string;
    openedAt: Date;
    isSuccess: boolean;
}
