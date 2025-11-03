export interface Event {
  id?: number;
  title: string;
  description?: string;
  date?: string;
  time?: string;
  price?: number;
  imageUrl?: string;
  link?: string;
  categoryId?: number;
  locationId?: number;
  category?: Category;
  location?: EventLocation;
  published?: boolean;
  viewCount?: number;
  createdAt?: string;
  updatedAt?: string;
}
export interface Category {
  id?: number;
  name: string;
  description?: string;
}
export interface EventLocation {
  id?: number;
  name: string;
  address?: string;
  city?: string;
  country?: string;
  latitude?: number;
  longitude?: number;
}
export interface User {
  id?: number;
  name: string;
  email: string;
  password?: string;
  locationId?: number;
  location?: EventLocation;
  avatarUrl?: string;
  createdAt?: string;
}
