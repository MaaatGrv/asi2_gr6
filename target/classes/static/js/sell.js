function loadUserCards() {
    $.ajax({
        url: "/auth/user",
        type: "GET",
        success: function(user) {
            if (user && user.id) {
                $.ajax({
                    url: "/user/" + user.id + "/cards",
                    type: "GET",
                    success: function(cards) {
                        displayCards(cards);
                    },
                    error: function(error) {
                        console.error("Error while fetching user cards: ", error);
                    }
                });
            }
        },
        error: function(error) {
            console.error("Error while fetching logged in user: ", error);
        }
    });
}

function displayCards(cards) {
    var tableContent = $("#tableContent");
    var rowTemplate = $("#row");

    cards.forEach(function(card) {
        var row = rowTemplate.html()
            .replace(/{{img_src}}/g, card.imgUrl)
            .replace(/{{name}}/g, card.name)
            .replace(/{{description}}/g, card.description)
            .replace(/{{family_name}}/g, card.family)
            .replace(/{{hp}}/g, card.hp)
            .replace(/{{energy}}/g, card.energy)
            .replace(/{{defense}}/g, card.defence)
            .replace(/{{attack}}/g, card.attack)
            .replace(/{{price}}/g, card.price)
            .replace(/{{card_id}}/g, card.id);
        tableContent.append(row);
    });
}

$(document).on("click", ".sell-button", function() {
    // Code pour gérer le clic sur le bouton "Sell".
});

$(document).on("click", "#tableContent tr", function() {
    var cardId = $(this).data("card-id");
    loadCardDetails(cardId);
});

function loadCardDetails(cardId) {
    $.ajax({
        url: "/card/" + cardId,
        type: "GET",
        success: function(card) {
            updateCard(card);
        },
        error: function(error) {
            console.error("Error while fetching card details: ", error);
        }
    });
}

function updateCard(card) {
    $("#cardHPId").text(card.hp);
    $("h5").text(card.family);
    $("#energyId").text(card.energy);
    $("#cardImgId").attr("src", card.imgUrl);
    $("#cardNameId").text(card.name);
    $("#cardDescriptionId").text(card.description);
    $("#cardHPId").text(card.hp);
    $("#cardEnergyId").text("Energy " + card.energy);
    $("#cardAttackId").text("Attack " + card.attack);
    $("#cardDefenceId").text("Defense " + card.defence);
    $("#cardPriceId").text(card.price + "$");
}

$(document).ready(function() {
    $("#card").load("/part/card-full.html", function() {
        loadUserCards();
    });
});

