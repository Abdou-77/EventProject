package com.atlas.backend.config;

import com.atlas.backend.model.*;
import com.atlas.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        // Check if data already exists
        if (categoryRepository.count() > 0) {
            System.out.println("✅ Database already populated. Skipping seed.");
            return;
        }

        System.out.println("🌱 Starting database seeding with French events data...");

        // 1. Create Categories
        List<Category> categories = createCategories();
        System.out.println("✅ Created " + categories.size() + " categories");

        // 2. Create Locations
        List<Location> locations = createLocations();
        System.out.println("✅ Created " + locations.size() + " locations");

        // 3. Create Events (36 events)
        List<Event> events = createEvents(categories, locations);
        System.out.println("✅ Created " + events.size() + " events");

        // 4. Create Sample Users
        List<User> users = createUsers(locations);
        System.out.println("✅ Created " + users.size() + " users");

        System.out.println("🎉 Database seeding completed successfully!");
    }

    private List<Category> createCategories() {
        List<Category> categories = new ArrayList<>();

        categories.add(createCategory("Musique", "🎵"));
        categories.add(createCategory("Théâtre", "🎭"));
        categories.add(createCategory("Sport", "⚽"));
        categories.add(createCategory("Art & Exposition", "🎨"));
        categories.add(createCategory("Festival", "🎪"));
        categories.add(createCategory("Gastronomie", "🍷"));
        categories.add(createCategory("Cinéma", "🎬"));
        categories.add(createCategory("Conférence", "📚"));

        return categoryRepository.saveAll(categories);
    }

    private Category createCategory(String name, String icon) {
        Category category = new Category();
        category.setName(name);
        category.setIconUrl(icon);
        return category;
    }

    private List<Location> createLocations() {
        List<Location> locations = new ArrayList<>();

        // Paris
        locations.add(createLocation("Stade de France", "93200 Saint-Denis", "Paris",
            new BigDecimal("48.924444"), new BigDecimal("2.360000")));
        locations.add(createLocation("Accor Arena", "8 Boulevard de Bercy", "Paris",
            new BigDecimal("48.839167"), new BigDecimal("2.379167")));
        locations.add(createLocation("Philharmonie de Paris", "221 Avenue Jean Jaurès", "Paris",
            new BigDecimal("48.889444"), new BigDecimal("2.393333")));
        locations.add(createLocation("Musée du Louvre", "Rue de Rivoli", "Paris",
            new BigDecimal("48.860833"), new BigDecimal("2.337222")));
        locations.add(createLocation("Parc des Princes", "24 Rue du Commandant Guilbaud", "Paris",
            new BigDecimal("48.841389"), new BigDecimal("2.253056")));

        // Lyon
        locations.add(createLocation("Halle Tony Garnier", "20 Place Antonin Perrin", "Lyon",
            new BigDecimal("45.730556"), new BigDecimal("4.826944")));
        locations.add(createLocation("Musée des Confluences", "86 Quai Perrache", "Lyon",
            new BigDecimal("45.732500"), new BigDecimal("4.818056")));

        // Marseille
        locations.add(createLocation("Stade Vélodrome", "3 Boulevard Michelet", "Marseille",
            new BigDecimal("43.269722"), new BigDecimal("5.395833")));
        locations.add(createLocation("Le Dôme", "48 Avenue de Saint-Just", "Marseille",
            new BigDecimal("43.312222"), new BigDecimal("5.389444")));

        // Bordeaux
        locations.add(createLocation("Matmut Atlantique", "Cours Jules Ladoumègue", "Bordeaux",
            new BigDecimal("44.897500"), new BigDecimal("-0.561111")));

        // Nice
        locations.add(createLocation("Allianz Riviera", "Boulevard des Jardiniers", "Nice",
            new BigDecimal("43.705278"), new BigDecimal("7.192778")));

        return locationRepository.saveAll(locations);
    }

    private Location createLocation(String name, String address, String city, BigDecimal lat, BigDecimal lon) {
        Location location = new Location();
        location.setName(name);
        location.setAddress(address);
        location.setCity(city);
        location.setLatitude(lat);
        location.setLongitude(lon);
        return location;
    }

    private List<Event> createEvents(List<Category> categories, List<Location> locations) {
        List<Event> events = new ArrayList<>();

        // Musique Events
        events.add(createEvent(
            "Concert de David Guetta",
            "Le célèbre DJ français présente son nouveau spectacle avec effets pyrotechniques exceptionnels. Une soirée électro inoubliable avec les plus grands hits.",
            LocalDate.of(2025, 12, 15),
            LocalTime.of(20, 30),
            new BigDecimal("75.00"),
            "https://images.unsplash.com/photo-1470229722913-7c0e2dbbafd3?w=800&h=600&fit=crop",
            "https://www.ticketmaster.fr",
            categories.get(0).getId(), // Musique
            locations.get(1).getId(), // Accor Arena
            true,
            1250
        ));

        events.add(createEvent(
            "Festival Jazz à Vienne 2025",
            "40ème édition du célèbre festival de jazz avec des artistes internationaux. Marcus Miller, Herbie Hancock et bien d'autres légendes du jazz.",
            LocalDate.of(2025, 7, 5),
            LocalTime.of(19, 0),
            new BigDecimal("55.00"),
            "https://images.unsplash.com/photo-1415201364774-f6f0bb35f28f?w=800&h=600&fit=crop",
            "https://www.jazzavienne.com",
            categories.get(4).getId(), // Festival
            locations.get(2).getId(), // Philharmonie
            true,
            856
        ));

        events.add(createEvent(
            "Concert Symphonique - Orchestre de Paris",
            "Soirée exceptionnelle avec l'Orchestre de Paris sous la direction de Gustavo Dudamel. Au programme : Beethoven et Mahler.",
            LocalDate.of(2025, 11, 20),
            LocalTime.of(20, 0),
            new BigDecimal("45.00"),
            "https://images.unsplash.com/photo-1465847899084-d164df4dedc6?w=800&h=600&fit=crop",
            "https://philharmoniedeparis.fr",
            categories.get(0).getId(), // Musique
            locations.get(2).getId(), // Philharmonie
            true,
            423
        ));

        // Sport Events
        events.add(createEvent(
            "PSG vs Olympique de Marseille",
            "Le Classique - Match de football entre les deux rivaux historiques du championnat français. L'affrontement le plus attendu de la saison !",
            LocalDate.of(2025, 11, 30),
            LocalTime.of(21, 0),
            new BigDecimal("120.00"),
            "https://images.unsplash.com/photo-1522778119026-d647f0596c20?w=800&h=600&fit=crop",
            "https://www.psg.fr",
            categories.get(2).getId(), // Sport
            locations.get(4).getId(), // Parc des Princes
            true,
            2847
        ));

        events.add(createEvent(
            "Finale Top 14 Rugby",
            "Grande finale du championnat de France de rugby au Stade de France. Les deux meilleures équipes s'affrontent pour le titre de champion !",
            LocalDate.of(2025, 6, 21),
            LocalTime.of(21, 0),
            new BigDecimal("95.00"),
            "https://images.unsplash.com/photo-1486286701208-1d58e9338013?w=800&h=600&fit=crop",
            "https://www.lnr.fr",
            categories.get(2).getId(), // Sport
            locations.get(0).getId(), // Stade de France
            true,
            3456
        ));

        // Théâtre Events
        events.add(createEvent(
            "Le Misanthrope - Comédie Française",
            "Chef-d'œuvre de Molière revisité dans une mise en scène contemporaine époustouflante. Une réflexion mordante sur la société et l'authenticité.",
            LocalDate.of(2025, 12, 10),
            LocalTime.of(19, 30),
            new BigDecimal("38.00"),
            "https://images.unsplash.com/photo-1503095396549-807759245b35?w=800&h=600&fit=crop",
            "https://www.comedie-francaise.fr",
            categories.get(1).getId(), // Théâtre
            locations.get(3).getId(), // Musée du Louvre area
            true,
            234
        ));

        // Art & Exposition Events
        events.add(createEvent(
            "Exposition Monet - Impressionnisme",
            "Rétrospective exceptionnelle des œuvres de Claude Monet avec plus de 150 tableaux. Plongez dans l'univers des Nymphéas et de la lumière impressionniste.",
            LocalDate.of(2025, 11, 15),
            LocalTime.of(10, 0),
            new BigDecimal("18.00"),
            "https://images.unsplash.com/photo-1577083552431-6e5fd01988ec?w=800&h=600&fit=crop",
            "https://www.louvre.fr",
            categories.get(3).getId(), // Art
            locations.get(3).getId(), // Musée du Louvre
            true,
            1567
        ));

        events.add(createEvent(
            "Exposition - Trésors de l'Égypte Antique",
            "Découvrez les mystères des pharaons avec des objets jamais exposés en France. Sarcophages, bijoux et artefacts millénaires vous attendent.",
            LocalDate.of(2025, 12, 1),
            LocalTime.of(9, 0),
            new BigDecimal("22.00"),
            "https://images.unsplash.com/photo-1595433707802-6b2626ef1c91?w=800&h=600&fit=crop",
            "https://www.confluences.fr",
            categories.get(3).getId(), // Art
            locations.get(6).getId(), // Musée des Confluences
            true,
            892
        ));

        // Festival Events
        events.add(createEvent(
            "Les Nuits de Fourvière",
            "Festival pluridisciplinaire dans le cadre magique du théâtre antique de Lyon. Musique, danse, théâtre et cinéma sous les étoiles.",
            LocalDate.of(2025, 7, 15),
            LocalTime.of(21, 30),
            new BigDecimal("42.00"),
            "https://images.unsplash.com/photo-1533174072545-7a4b6ad7a6c3?w=800&h=600&fit=crop",
            "https://www.nuitsdefourviere.com",
            categories.get(4).getId(), // Festival
            locations.get(5).getId(), // Halle Tony Garnier
            true,
            1124
        ));

        events.add(createEvent(
            "Fête de la Musique Paris",
            "Concerts gratuits dans toute la ville pour célébrer l'arrivée de l'été. Plus de 1000 concerts dans tous les quartiers de Paris !",
            LocalDate.of(2025, 6, 21),
            LocalTime.of(18, 0),
            new BigDecimal("0.00"),
            "https://images.unsplash.com/photo-1493225457124-a3eb161ffa5f?w=800&h=600&fit=crop",
            "https://fetedelamusique.paris",
            categories.get(4).getId(), // Festival
            locations.get(2).getId(), // Philharmonie
            true,
            5234
        ));

        // Gastronomie Events
        events.add(createEvent(
            "Salon du Chocolat Paris",
            "Le plus grand événement mondial dédié au chocolat et au cacao. Dégustations, défilés de robes en chocolat et rencontres avec les meilleurs chocolatiers.",
            LocalDate.of(2025, 10, 28),
            LocalTime.of(10, 0),
            new BigDecimal("15.00"),
            "https://images.unsplash.com/photo-1511381939415-e44015466834?w=800&h=600&fit=crop",
            "https://www.salon-du-chocolat.com",
            categories.get(5).getId(), // Gastronomie
            locations.get(1).getId(), // Accor Arena
            true,
            2341
        ));

        events.add(createEvent(
            "Bordeaux Fête le Vin",
            "Festival bisannuel célébrant les vins de Bordeaux. Dégustations de grands crus, ateliers œnologiques et animations sur les quais de la Garonne.",
            LocalDate.of(2026, 6, 18),
            LocalTime.of(11, 0),
            new BigDecimal("25.00"),
            "https://images.unsplash.com/photo-1510812431401-41d2bd2722f3?w=800&h=600&fit=crop",
            "https://www.bordeaux-fete-le-vin.com",
            categories.get(5).getId(), // Gastronomie
            locations.get(9).getId(), // Matmut Atlantique
            true,
            1687
        ));

        // Cinéma Events
        events.add(createEvent(
            "Festival de Cannes - Projection Spéciale",
            "Avant-première mondiale d'un film français très attendu. Rencontre avec les réalisateurs et acteurs après la projection.",
            LocalDate.of(2025, 5, 20),
            LocalTime.of(20, 0),
            new BigDecimal("50.00"),
            "https://images.unsplash.com/photo-1478720568477-152d9b164e26?w=800&h=600&fit=crop",
            "https://www.festival-cannes.fr",
            categories.get(6).getId(), // Cinéma
            locations.get(10).getId(), // Allianz Riviera
            true,
            678
        ));

        // Conférence Events
        events.add(createEvent(
            "TedX Paris - Innovation & Futur",
            "Conférence inspirante avec des speakers internationaux. IA, robotique, biotechnologies : découvrez les innovations qui changeront demain.",
            LocalDate.of(2025, 11, 5),
            LocalTime.of(14, 0),
            new BigDecimal("35.00"),
            "https://images.unsplash.com/photo-1505373877841-8d25f7d46678?w=800&h=600&fit=crop",
            "https://www.tedxparis.com",
            categories.get(7).getId(), // Conférence
            locations.get(1).getId(), // Accor Arena
            true,
            945
        ));

        events.add(createEvent(
            "Salon du Livre de Paris",
            "Le plus grand rassemblement littéraire de France. Plus de 1200 auteurs, dédicaces, conférences et animations pour petits et grands.",
            LocalDate.of(2025, 3, 15),
            LocalTime.of(9, 30),
            new BigDecimal("12.00"),
            "https://images.unsplash.com/photo-1481627834876-b7833e8f5570?w=800&h=600&fit=crop",
            "https://www.livreparis.com",
            categories.get(7).getId(), // Conférence
            locations.get(0).getId(), // Stade de France area
            true,
            2156
        ));

        // Additional Music Events
        events.add(createEvent(
            "Stromae - Tournée Multitude",
            "Le retour triomphal de Stromae avec son nouvel album acclamé par la critique. Chorégraphies innovantes et mise en scène théâtrale pour une expérience unique.",
            LocalDate.of(2025, 12, 20),
            LocalTime.of(20, 0),
            new BigDecimal("85.00"),
            "https://images.unsplash.com/photo-1540039155733-5bb30b53aa14?w=800&h=600&fit=crop",
            "https://www.stromae.com",
            categories.get(0).getId(), // Musique
            locations.get(7).getId(), // Stade Vélodrome
            true,
            3421
        ));

        events.add(createEvent(
            "Christine and the Queens - Concert Live",
            "Spectacle visuel et musical époustouflant de l'artiste française primée. Performance énergique mêlant pop, électro et danse contemporaine.",
            LocalDate.of(2025, 11, 25),
            LocalTime.of(20, 30),
            new BigDecimal("68.00"),
            "https://images.unsplash.com/photo-1501386761578-eac5c94b800a?w=800&h=600&fit=crop",
            "https://www.christineandthequeens.com",
            categories.get(0).getId(), // Musique
            locations.get(5).getId(), // Halle Tony Garnier Lyon
            true,
            1845
        ));

        events.add(createEvent(
            "Daft Punk Tribute Show",
            "Hommage spectaculaire au duo légendaire avec effets lasers et pyrotechnie. Revivez l'euphorie des concerts mythiques avec les plus grands tubes électro.",
            LocalDate.of(2025, 12, 31),
            LocalTime.of(22, 0),
            new BigDecimal("90.00"),
            "https://images.unsplash.com/photo-1514525253161-7a46d19cd819?w=800&h=600&fit=crop",
            "https://www.daftpunktribute.fr",
            categories.get(0).getId(), // Musique
            locations.get(1).getId(), // Accor Arena
            true,
            4567
        ));

        events.add(createEvent(
            "Festival Électro Lyon",
            "Les meilleurs DJs européens réunis pour une nuit électro inoubliable. Techno, house, trance : 12h de musique non-stop sur 3 scènes.",
            LocalDate.of(2025, 9, 12),
            LocalTime.of(20, 0),
            new BigDecimal("45.00"),
            "https://images.unsplash.com/photo-1516450360452-9312f5e86fc7?w=800&h=600&fit=crop",
            "https://www.festivalelectrolyon.fr",
            categories.get(4).getId(), // Festival
            locations.get(5).getId(), // Halle Tony Garnier
            true,
            2890
        ));

        // More Sport Events
        events.add(createEvent(
            "Roland-Garros - Finale Messieurs",
            "Grande finale du tournoi de tennis français, l'un des quatre tournois du Grand Chelem. Les meilleurs joueurs mondiaux s'affrontent sur terre battue pour le titre suprême.",
            LocalDate.of(2025, 6, 8),
            LocalTime.of(15, 0),
            new BigDecimal("250.00"),
            "https://images.unsplash.com/photo-1587280501635-68a0e82cd5ff?w=800&h=600&fit=crop",
            "https://www.rolandgarros.com",
            categories.get(2).getId(), // Sport
            locations.get(4).getId(), // Parc des Princes area
            true,
            5678
        ));

        events.add(createEvent(
            "Tour de France - Arrivée Champs-Élysées",
            "L'arrivée mythique de la dernière étape du Tour de France sur les Champs-Élysées. Ambiance festive garantie pour célébrer le maillot jaune ! Accès gratuit.",
            LocalDate.of(2025, 7, 27),
            LocalTime.of(14, 0),
            new BigDecimal("0.00"),
            "https://images.unsplash.com/photo-1541625602330-2277a4c46182?w=800&h=600&fit=crop",
            "https://www.letour.fr",
            categories.get(2).getId(), // Sport
            locations.get(4).getId(), // Paris
            true,
            12450
        ));

        events.add(createEvent(
            "Marathon de Paris 2025",
            "42,195 km à travers les plus beaux monuments de la capitale française. Traversez Paris de la Tour Eiffel aux Champs-Élysées dans une ambiance unique !",
            LocalDate.of(2025, 4, 6),
            LocalTime.of(8, 30),
            new BigDecimal("120.00"),
            "https://images.unsplash.com/photo-1452626038306-9aae5e071dd3?w=800&h=600&fit=crop",
            "https://www.schneiderelectricparismarathon.com",
            categories.get(2).getId(), // Sport
            locations.get(4).getId(), // Paris
            true,
            8934
        ));

        // More Theatre Events
        events.add(createEvent(
            "Cyrano de Bergerac",
            "La célèbre pièce d'Edmond Rostand dans une mise en scène moderne et audacieuse. L'histoire intemporelle du poète au grand cœur revisitée avec brio.",
            LocalDate.of(2025, 10, 18),
            LocalTime.of(20, 0),
            new BigDecimal("42.00"),
            "https://images.unsplash.com/photo-1507676184212-d03ab07a01bf?w=800&h=600&fit=crop",
            "https://www.theatre-paris.com",
            categories.get(1).getId(), // Théâtre
            locations.get(2).getId(), // Philharmonie area
            true,
            567
        ));

        events.add(createEvent(
            "Les Liaisons Dangereuses",
            "Chef-d'œuvre du théâtre français avec une distribution prestigieuse. Intrigues, séduction et manipulation dans l'aristocratie du XVIIIe siècle.",
            LocalDate.of(2025, 11, 8),
            LocalTime.of(19, 0),
            new BigDecimal("55.00"),
            "https://images.unsplash.com/photo-1516541196182-6bdb0516ed27?w=800&h=600&fit=crop",
            "https://www.theatre-odeon.fr",
            categories.get(1).getId(), // Théâtre
            locations.get(3).getId(), // Paris
            true,
            823
        ));

        events.add(createEvent(
            "Roméo et Juliette - Ballet",
            "Interprétation magistrale du ballet classique par l'Opéra de Paris. Prokofiev et Shakespeare réunis pour une soirée inoubliable de grâce et d'émotion.",
            LocalDate.of(2025, 12, 5),
            LocalTime.of(19, 30),
            new BigDecimal("78.00"),
            "https://images.unsplash.com/photo-1518834107812-67b0b7c58434?w=800&h=600&fit=crop",
            "https://www.operadeparis.fr",
            categories.get(1).getId(), // Théâtre
            locations.get(2).getId(), // Philharmonie
            true,
            1234
        ));

        // More Art & Expositions
        events.add(createEvent(
            "Van Gogh - L'Expérience Immersive",
            "Plongez dans l'univers du maître avec des projections géantes à 360°. Découvrez les Tournesols, la Nuit Étoilée et bien d'autres chefs-d'œuvre.",
            LocalDate.of(2025, 10, 1),
            LocalTime.of(10, 0),
            new BigDecimal("24.00"),
            "https://images.unsplash.com/photo-1579783902614-a3fb3927b6a5?w=800&h=600&fit=crop",
            "https://www.vangogh-expo.com",
            categories.get(3).getId(), // Art
            locations.get(1).getId(), // Accor Arena
            true,
            3456
        ));

        events.add(createEvent(
            "Picasso et les Maîtres",
            "Dialogue artistique entre Picasso et les grands maîtres de l'histoire de l'art. Une exposition unique mettant en lumière les influences du génie cubiste.",
            LocalDate.of(2025, 9, 15),
            LocalTime.of(9, 30),
            new BigDecimal("16.00"),
            "https://images.unsplash.com/photo-1547826039-bfc35e0f1ea8?w=800&h=600&fit=crop",
            "https://www.musee-picasso.fr",
            categories.get(3).getId(), // Art
            locations.get(3).getId(), // Musée du Louvre
            true,
            2134
        ));

        // More Festival Events
        events.add(createEvent(
            "Festival d'Avignon",
            "Le plus important festival de théâtre et des arts vivants au monde. Plus de 40 spectacles dans des lieux prestigieux et insolites.",
            LocalDate.of(2025, 7, 10),
            LocalTime.of(18, 0),
            new BigDecimal("38.00"),
            "https://images.unsplash.com/photo-1492684223066-81342ee5ff30?w=800&h=600&fit=crop",
            "https://www.festival-avignon.com",
            categories.get(4).getId(), // Festival
            locations.get(6).getId(), // Lyon area
            true,
            4321
        ));

        events.add(createEvent(
            "Nuit Blanche Paris",
            "Art contemporain gratuit toute la nuit dans les rues de Paris. Installations, performances et œuvres éphémères dans toute la capitale.",
            LocalDate.of(2025, 10, 4),
            LocalTime.of(19, 0),
            new BigDecimal("0.00"),
            "https://images.unsplash.com/photo-1509824227185-9c5a01ceba0d?w=800&h=600&fit=crop",
            "https://www.nuitblanche.paris",
            categories.get(4).getId(), // Festival
            locations.get(3).getId(), // Paris
            true,
            8765
        ));

        events.add(createEvent(
            "Fête des Lumières Lyon",
            "Festival lumineux spectaculaire pendant 4 jours dans toute la ville de Lyon. Installations monumentales et mapping vidéo époustouflants.",
            LocalDate.of(2025, 12, 8),
            LocalTime.of(18, 0),
            new BigDecimal("0.00"),
            "https://images.unsplash.com/photo-1513836279014-a89f7a76ae86?w=800&h=600&fit=crop",
            "https://www.fetedeslumieres.lyon.fr",
            categories.get(4).getId(), // Festival
            locations.get(5).getId(), // Lyon
            true,
            15234
        ));

        // More Gastronomie Events
        events.add(createEvent(
            "Bocuse d'Or - Finale Mondiale",
            "Le plus prestigieux concours de gastronomie au monde à Lyon. Les meilleurs chefs s'affrontent pour le titre suprême de la cuisine française.",
            LocalDate.of(2025, 9, 23),
            LocalTime.of(11, 0),
            new BigDecimal("150.00"),
            "https://images.unsplash.com/photo-1414235077428-338989a2e8c0?w=800&h=600&fit=crop",
            "https://www.bocusedor.com",
            categories.get(5).getId(), // Gastronomie
            locations.get(5).getId(), // Lyon
            true,
            1876
        ));

        events.add(createEvent(
            "Foire aux Vins de Colmar",
            "La plus ancienne foire aux vins de France avec plus de 600 exposants. Dégustations, rencontres avec les vignerons et animations œnologiques.",
            LocalDate.of(2025, 8, 5),
            LocalTime.of(10, 0),
            new BigDecimal("10.00"),
            "https://images.unsplash.com/photo-1547595628-c61a29f496f0?w=800&h=600&fit=crop",
            "https://www.foire-colmar.com",
            categories.get(5).getId(), // Gastronomie
            locations.get(0).getId(), // Stade de France area
            true,
            2567
        ));

        // More Cinema Events
        events.add(createEvent(
            "Festival Lumière Lyon",
            "Célébration du patrimoine cinématographique avec rétrospectives et avant-premières. Hommages aux plus grandes figures du 7ème art.",
            LocalDate.of(2025, 10, 12),
            LocalTime.of(14, 0),
            new BigDecimal("28.00"),
            "https://images.unsplash.com/photo-1489599849927-2ee91cede3ba?w=800&h=600&fit=crop",
            "https://www.festival-lumiere.org",
            categories.get(6).getId(), // Cinéma
            locations.get(5).getId(), // Lyon
            true,
            1456
        ));

        events.add(createEvent(
            "Nuit des Oscars - Projection & Cérémonie",
            "Suivez la cérémonie en direct avec projection sur grand écran et cocktail. Ambiance Hollywood garantie avec tapis rouge et dress code.",
            LocalDate.of(2026, 2, 22),
            LocalTime.of(2, 0),
            new BigDecimal("35.00"),
            "https://images.unsplash.com/photo-1485846234645-a62644f84728?w=800&h=600&fit=crop",
            "https://www.ugc.fr",
            categories.get(6).getId(), // Cinéma
            locations.get(1).getId(), // Accor Arena
            true,
            987
        ));

        // More Conference Events
        events.add(createEvent(
            "VivaTech Paris 2025",
            "Le plus grand salon européen de l'innovation technologique et des startups. IA, robotique, blockchain : découvrez les technologies de demain.",
            LocalDate.of(2025, 5, 22),
            LocalTime.of(9, 0),
            new BigDecimal("99.00"),
            "https://images.unsplash.com/photo-1540575467063-178a50c2df87?w=800&h=600&fit=crop",
            "https://www.vivatechnology.com",
            categories.get(7).getId(), // Conférence
            locations.get(0).getId(), // Stade de France
            true,
            7654
        ));

        LocalDateTime now = LocalDateTime.now();
        for (Event event : events) {
            event.setCreatedAt(now);
            event.setUpdatedAt(now);
            if (event.getViewCount() == null) {
                event.setViewCount(0);
            }
        }

        return eventRepository.saveAll(events);
    }

    private Event createEvent(String title, String description, LocalDate date, LocalTime time,
                            BigDecimal price, String imageUrl, String link,
                            Long categoryId, Long locationId, Boolean published, Integer viewCount) {
        Event event = new Event();
        event.setTitle(title);
        event.setDescription(description);
        event.setDate(date);
        event.setTime(time);
        event.setPrice(price);
        event.setImageUrl(imageUrl);
        event.setLink(link);
        event.setCategoryId(categoryId);
        event.setLocationId(locationId);
        event.setPublished(published);
        event.setViewCount(viewCount);
        return event;
    }

    private List<User> createUsers(List<Location> locations) {
        List<User> users = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();

        users.add(createUser("Sophie Martin", "sophie.martin@email.fr", "password123",
            locations.get(0).getId(), "https://i.pravatar.cc/150?img=1", now));
        users.add(createUser("Thomas Dubois", "thomas.dubois@email.fr", "password123",
            locations.get(4).getId(), "https://i.pravatar.cc/150?img=2", now));
        users.add(createUser("Marie Lambert", "marie.lambert@email.fr", "password123",
            locations.get(5).getId(), "https://i.pravatar.cc/150?img=3", now));
        users.add(createUser("Pierre Rousseau", "pierre.rousseau@email.fr", "password123",
            locations.get(7).getId(), "https://i.pravatar.cc/150?img=4", now));
        users.add(createUser("Emma Leroy", "emma.leroy@email.fr", "password123",
            locations.get(9).getId(), "https://i.pravatar.cc/150?img=5", now));

        return userRepository.saveAll(users);
    }

    private User createUser(String name, String email, String password, Long locationId,
                          String avatarUrl, LocalDateTime createdAt) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password); // In production, use BCrypt
        user.setLocationId(locationId);
        user.setAvatarUrl(avatarUrl);
        user.setCreatedAt(createdAt);
        return user;
    }
}

