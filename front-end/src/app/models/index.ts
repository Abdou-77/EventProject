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
  location?: Location;
  published?: boolean;
  viewCount?: number;
  createdAt?: string;
  updatedAt?: string;
  featured?: boolean;
  tags?: string[];
  isFavorite?: boolean;
}

export interface Category {
  id?: number;
  name: string;
  description?: string;
  iconUrl?: string;
  color?: string;
  eventCount?: number;
}

export interface Location {
  id?: number;
  name: string;
  address?: string;
  city: string;
  country?: string;
  latitude?: number;
  longitude?: number;
  capacity?: number;
  imageUrl?: string;
}

export interface User {
  id?: number;
  name: string;
  email: string;
  password?: string;
  locationId?: number;
  location?: Location;
  avatarUrl?: string;
  createdAt?: string;
  bio?: string;
  role?: 'USER' | 'ADMIN' | 'ORGANIZER';
  preferences?: UserPreferences;
}

export interface UserPreferences {
  id?: number;
  userId: number;
  favoriteCategories?: number[];
  favoriteLocations?: number[];
  notificationsEnabled?: boolean;
  emailUpdates?: boolean;
}

export interface Favorite {
  id?: number;
  userId: number;
  eventId: number;
  createdAt?: string;
}

export interface EventFilter {
  search?: string;
  categoryId?: number;
  locationId?: number;
  city?: string;
  minPrice?: number;
  maxPrice?: number;
  startDate?: string;
  endDate?: string;
  featured?: boolean;
  sortBy?: 'date' | 'price' | 'popularity' | 'relevance';
  sortOrder?: 'asc' | 'desc';
}

export interface PaginatedResponse<T> {
  content: T[];
  totalElements: number;
  totalPages: number;
  size: number;
  number: number;
  first: boolean;
  last: boolean;
}

export interface ApiResponse<T> {
  success: boolean;
  data?: T;
  message?: string;
  errors?: string[];
}

export type EventStatus = 'draft' | 'published' | 'cancelled' | 'sold_out';
export type UserRole = 'user' | 'admin' | 'organizer';
