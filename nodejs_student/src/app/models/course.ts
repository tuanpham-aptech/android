export interface Course {
  editMode: boolean;
  _id: string;
  name: string;
  class: number;
  type: number;
  subject: number;
  createdAt: Date;
  updatedAt: Date;
  viewVideos: boolean;
  videoIds: Array<string>;
}
