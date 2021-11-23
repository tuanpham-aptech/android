export interface Student {
  name: string;
  username: string;
  password: string;
  type: number;
  class: number;
  status: number;
  courses: Array<string>;
  createdAt: Date;
  updatedAt: Date;
  role: string;
  birthday: string;
  editMode: boolean;
  _id: string;
}
