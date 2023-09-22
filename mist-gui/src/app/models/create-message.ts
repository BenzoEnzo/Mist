export interface CreateMessageRequest {
    content: string;
    deleteAfterTime: number;
}
export interface CreateMessageResponse {
    id: string;
    sendAt: Date;
}
